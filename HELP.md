## JDK
Для работы потребуется [JDK 25](https://www.oracle.com/java/technologies/downloads/#jdk25)

Для проверки установки воспользуйтесь
```
java -version
```
Также убедитесь, что Java добавлена в системную переменную среды *PATH*
## Запуск тестов
### Windows
```
gradlew test
```
### Linux / MacOS
```
./gradlew test
```
После выполнения зависимости будут автоматически установлены, результат появится в консоли
Подробный отчёт по тестам можно будет найти в файле
```
build/reports/tests/test/index.html
```