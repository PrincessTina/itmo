#ifndef DYNAMIC_ARRAY_AND_LINKED_LIST_ARRAY_H
#define DYNAMIC_ARRAY_AND_LINKED_LIST_ARRAY_H

class Array final {
    int *firstElementPointer;
    int maxSize = 16;
    int currentSize = 0;

public:
    Array();

    Array(int capacity);

    ~Array();

    void insert(const int &value);

    void insert(int index, const int &value);

    void remove(int index);

    const int &operator[](int index) const;

    int &operator[](int index);

    int size() const;
};

#include "array_impl.h"

#endif //DYNAMIC_ARRAY_AND_LINKED_LIST_ARRAY_H