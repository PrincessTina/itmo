#include <stdio.h>
#include <malloc.h>
#include <time.h>
#include "main.h"

bmpHeader header;
image_t image;
int condition = 0;

int main(void) {
    char *filename = "/home/princess/itmo/yasp/lab7_m/cmake-build-debug/test.bmp";
    double begin, end, time;
    FILE *file = openFile(filename);

    switch (condition) {
        case READ_INVALID_SIGNATURE:
            printf("Failed while opening file. Maybe file is corrupted\n");
            goto breakPoint;
        default:
            printf("Successfully read from file %s\n", filename);
    }

    readBMP(file);

    switch (condition) {
        case ROTATE_OK:
            printf("Successfully created new array with yellowed points of pixels\n");
            break;
        case READ_OK:
            printf("Can read from file but cannot create new array with yellowed points\n");
        default:
            printf("Something bad adventured while rotating\n");
            goto breakPoint;
    }

    /* turn over file  ASM*/
    begin = clock();
    /*sepia(image.array, image.height * image.width, image.array);*/
    doPartAsmSepia();
    end = clock();
    time = (end - begin) / CLOCKS_PER_SEC;
    printf("SSE sepia time: %f\n", time);

    filename = "sepiaA.bmp";
    saveBMP(filename);

    switch (condition) {
        case WRITE_OK:
            printf("Successfully write in file %s\n", filename);
            break;
        default:
            printf("Something bad adventured while writing in file\n");
    }


    /* turn over file  SI*/
    filename = "/home/princess/itmo/yasp/lab7_m/cmake-build-debug/test.bmp";
    file = openFile(filename);
    readBMP(file);

    begin = clock();
    /*yellow();*/
    doPartSiSepia();
    end = clock();
    time = (end - begin) / CLOCKS_PER_SEC;
    printf("C sepia time: %f\n", time);

    filename = "sepiaS.bmp";
    saveBMP(filename);

    switch (condition) {
        case WRITE_OK:
            printf("Successfully write in file %s\n", filename);
            break;
        default:
            printf("Something bad adventured while writing in file\n");
    }

    breakPoint:
    return 0;
}

FILE *openFile(char *filename) {
    FILE *file = fopen(filename, "rb");
    fread(&header, sizeof(bmpHeader), 1, file);

    if (header.b != 'B' || header.m != 'M' || header.biBitCount != 24) {
        condition = READ_INVALID_SIGNATURE;
    } else {
        condition = OPEN_OK;
    }

    return file;
}

unsigned char round(int x) {
    return (unsigned char) (x < 256 ? x : 255);
}

void doPartAsmSepia() {
    int i, j, e = 0, m_i = image.height / 2, m_j = image.width / 2, size = image.height * image.width;
    pixel_t *array = (pixel_t *) calloc((size_t) size, sizeof(pixel_t));

    sepia(image.array, size, array);

    for (i = 0; i < image.height; i++) {
        for (j = 0; j < image.width; j++) {
            if (((image.height - i <= m_i) && (image.height - i <= m_i + (j - m_j) * m_i / m_j)) ||
                ((i <= m_i) && (j >= m_j))) {
                image.array[e] = array[e];
            }

            e++;
        }
    }
}

void doPartSiSepia() {
    int i, j, k = 25, e = 0, m_i = image.height / 2, m_j = image.width / 2;

    for (i = 0; i < image.height; i++) {
        for (j = 0; j < image.width; j++) {
            if (((image.height - i <= m_i) && (image.height - i <= m_i + (j - m_j) * m_i / m_j)) ||
                ((i <= m_i) && (j >= m_j))) {
                pixel_t new_pixel;
                int s = (image.array[e].r + image.array[e].g + image.array[e].b) / 3;

                new_pixel.r = round(s + 2 * k);
                new_pixel.g = round(s + k);
                new_pixel.b = round(s);

                image.array[e] = new_pixel;
            }

            e++;
        }
    }
}

void yellow() {
    int i, k = 30, size = image.width * image.height;

    for (i = 0; i < size; i++) {
        pixel_t new_pixel;
        int s = (image.array[i].r + image.array[i].g + image.array[i].b) / 3;

        new_pixel.r = round(s + 2 * k);
        new_pixel.g = round(s + k);
        new_pixel.b = round(s);

        image.array[i] = new_pixel;
    }
}

void readBMP(FILE *file) {
    int size;
    int ideal_width;
    int difference = 0;

    image.width = header.biWidth;
    image.height = header.biHeight;
    image.array = (pixel_t *) calloc(image.width * image.height, sizeof(pixel_t));
    ideal_width = 3 * image.width;

    while (ideal_width % 4 != 0) {
        ideal_width++;
        difference = ideal_width - 3 * image.width;
    }

    fseek(file, header.bfOffBytes, SEEK_SET);

    for (size = 0; size < image.height; size++) {
        fread(image.array + image.width * size, sizeof(pixel_t), image.width, file);
        fseek(file, (difference), SEEK_CUR);
    }

    condition = READ_OK;


    fclose(file);
    condition = ROTATE_OK;
}

void saveBMP(char *filename) {
    FILE *file = fopen(filename, "wb");
    int size;
    int ideal_width = 3 * image.width;
    int difference = 0;
    pixel_t pixel = {255, 255, 255};

    while (ideal_width % 4 != 0) {
        ideal_width++;
        difference = ideal_width - 3 * image.width;
    }

    header.bfOffBytes = sizeof(header);
    header.headerSize = 40;

    fwrite(&header, sizeof(bmpHeader), 1, file);

    for (size = 0; size < image.height; size++) {
        fwrite(image.array + image.width * size, sizeof(pixel_t), (size_t) image.width, file);
        fseek(file, difference, SEEK_CUR);
    }

    fwrite(&pixel, sizeof(pixel), 1, file);

    fclose(file);
    condition = WRITE_OK;
}

