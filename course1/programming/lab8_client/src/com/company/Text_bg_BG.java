package com.company;

import java.util.ListResourceBundle;

public class Text_bg_BG extends ListResourceBundle {
  private final Object[][] content = {
      {"file", "Файл"},
      {"load", "Изтегли"},
      {"mode", "Режим"},
      {"daylight", "Светъл"},
      {"nighttime", "Тъмен"},
      {"citySpirit", "С картинка"},
      {"language", "Език"},
      {"russian", "Руски"},
      {"german", "Немски"},
      {"english", "Английски"},
      {"bulgarian", "Български"},
      {"exit", "Изход"},
      {"commands", "Отбор"},
      {"info", "Информация"},
      {"add", "Добави"},
      {"remove_first", "Отстраняване на първо"},
      {"remove_all", "Изтриване на такива като"},
      {"modify", "Промени"},
      {"help", "Помощ"},
      {"platoon", "Взвод-мениджър"},
      {"help_text", "Използвайте една от командите: \n" +
          "\n Информация: Показва информация за колекцията" +
          "\n Добави: Добавя нов елемент в колекцията е във формат \n json" +
          "\n Извадете първата: Премахва първия елемент от колекция" +
          "\n Изтриване на такива, като: премахнете всички елементи,\n които са идентични посоченият формат json" +
          "\n Промени: Променя елементи от зададения номер" +
          "\n Изтегли: Обновяване/качване" +
          "\n Режим: Определя един от режимите" +
          "\n\n*Също така можете да кликнете с десния бутон на мишката или натиснете един от" +
          " колона от таблица, за да изберете опция за сортиране"},
      {"sort_by", "Подреди по"},
      {"names", "име"},
      {"ages", "възраст"},
      {"heights", "ръст"},
      {"hobbies", "хобита"},
      {"statuses", "статус"},
      {"ides", "курбан"},
      {"dates", "дата на създаване"},
      {"check_connection", "Проверете връзката си със сървъра"},
      {"empty_collection", "Колекцията е празна"},
      {"successfully_deleted", "Успешно изтрито"},
      {"warning", "Предупреждение"},
      {"name", "Име"},
      {"age", "Възраст"},
      {"height", "Ръст"},
      {"hobby", "Хобита"},
      {"status", "Статус"},
      {"id", "Курбан"},
      {"date", "Дата на създаване"},
      {"remove_elements", "Изтриете елементи"},
      {"input", "Въведете обект формат json"},
      {"objects", "съоръжения"},
      {"check_correctness", "Проверете правилното въвеждане на"},
      {"index", "Пощенски код"},
      {"input_index", "Въведете пощенски код на обекта, който искате \nпромените и след това неговите нови параметри"},
      {"input_index_", "Въведете пощенски код на обекта"},
      {"index_out", "Пощенски код обект извън достъпни кръг"},
      {"age_can", "Възрастта не може да бъде отрицателен"},
      {"height_can", "Растежът може да бъде само положителен"},
      {"successfully_modified", "Успешно променено"},
      {"error", "Грешка"},
      {"can_null", "Попълнете празните полета"},
      {"loading", "Данни актуално.\nКачвам нови данни.."},
      {"add_element", "За добавяне на елемент"},
      {"values", "Стойност"},
      {"successfully_added", "Успешно добавен"}
  };
  public Object[][] getContents() {
    return content;
  }
}
