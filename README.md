### Hexlet tests and linter status:
[![Actions Status](https://github.com/NikitaOguz/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/NikitaOguz/java-project-71/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-71)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-71)

Проект модуля #2
Вычислитель отличий

Вычислитель отличий – программа, определяющая разницу между двумя структурами данных. Это популярная задача, для решения которой существует множество онлайн-сервисов, например: http://www.jsondiff.com/. Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

Возможности утилиты:

Поддержка разных входных форматов: yaml и json
Генерация отчета в виде plain text, stylish и json
Пример использования:

Сравнение плоских файлов (JSON):

./build/install/app/bin/app file1.json file2.json

<img width="538" height="582" alt="image" src="https://github.com/user-attachments/assets/09298ea2-3fdf-4e65-a1c5-c52e4513793e" />

Сравнение плоских файлов (yaml):

./build/install/app/bin/app file1.yml file2.yml

<img width="539" height="586" alt="image" src="https://github.com/user-attachments/assets/531876ca-d8a4-4c5e-9c0c-90b38771b77e" />

Плоский формат:

./build/install/app/bin/app -f plain file1.json file2.json

<img width="756" height="313" alt="image" src="https://github.com/user-attachments/assets/ab00e2e3-20eb-4f85-9f56-dfad0c455cb3" />
