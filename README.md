# Лабораторная работа mylist
Реализация динамической структуры данных на основе массива с автоматическим расширением при переполнении.

## Описание работы
Требуется реализовать класс [MyList](./src/main/java/mylist/MyList.java), имитирующий работу ArrayList.

## Требования
### Общие требования
1) Запрещено использовать *Collections Framework*
2) Можно создавать любые приватные поля и методы (в рамках разумного), но должны быть реализованы все публичные методы и конструкторы из таблицы ниже
3) Поддержка каких-либо типов кроме *int* не требуется
4) Если поведение метода неочевидно из описания и тестов, то можно воспользоваться документацией к [ArrayList](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/ArrayList.html)
5) Все операции должны соответствовать указанной асимптотике.


### Публичные методы
```java 
public int get(int index)
```
Возвращает элемент по индексу, асимптотика O(1)
Допустимые значения 0 <= *index* < size.
В случае, если индекс выходит за границы, нужно кинуть [*IndexOutOfBoundsException*](https://docs.oracle.com/javase/8/docs/api/java/lang/IndexOutOfBoundsException.html) с помощью ключевого слова [*throw*](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)

```java
public void set(int index, int value)
```
Присваивает элементу с индексом *index* значение *value*
Допустимые значения 0 <= *index* < size.
В случае, если индекс выходит за границы, нужно кинуть [*IndexOutOfBoundsException*](https://docs.oracle.com/javase/8/docs/api/java/lang/IndexOutOfBoundsException.html) с помощью ключевого слова [*throw*](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)

```java
public void add(int value)
```
Добавляет элемент со значением *value* в конец списка, асимптотика O(1) *амортизированно*

```java
public void add(int index, int value)
```
Вставляет элемент в позицию index, асимптотика O(n)
Допустимые значения 0 <= *index* <= size.
В случае, если индекс выходит за границы, нужно кинуть [*IndexOutOfBoundsException*](https://docs.oracle.com/javase/8/docs/api/java/lang/IndexOutOfBoundsException.html) с помощью ключевого слова [*throw*](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)


```java
public void remove(int index)
```
Удаляет элемент по индексу, асимптотика O(n)
Допустимые значения 0 <= *index* < size.
В случае, если индекс выходит за границы, нужно кинуть [*IndexOutOfBoundsException*](https://docs.oracle.com/javase/8/docs/api/java/lang/IndexOutOfBoundsException.html) с помощью ключевого слова [*throw*](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)

```java
public int removeLast()
```
Удаляет элемент с конца и возвращает его.
В случае, если список пуст, нужно кинуть [*NoSuchElementException*](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/NoSuchElementException.html) с помощью ключевого слова [*throw*](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)

```java
public int indexOf(int value)
```
Возвращает индекс первого слева вхождения элемента (если такого нет, возвращает -1)

```java
public boolean contains(int value)
```
Возвращает *true*, если такое значение есть в списке, *false* иначе.

```java
public int size()
```
Возвращает текущий размер списка **(не capacity)**

```java
public boolean isEmpty()
```
Возвращает *true*, если список пуст, иначе *false*

```java
public int[] toArray()
```
Возвращает массив из элементов списка

```java
public void clear()
```
Удаляет все элементы списка (после вызова size() == 0)

```java
public boolean equals(Object o)
```
Два списка должны считаться равными если
1) имеют одинаковый размер
2) элементы в каждой позиции равны
```java
public int hashCode()
```
В данном задании требования к хэш-функции:
1) Соблюдение контракта с *equals*
2) Просто константу возвращать **нельзя** =)

### Публичные конструкторы
```java
public MyList()
```
Создаёт пустой список

```java
public MyList(int capacity)
```
Создаёт список с заданным capacity **(не размером)**. Если передано отрицательное значение, нужно кинуть [*IllegalArgumentException*](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/IllegalArgumentException.html) с помощью ключевого слова [*throw*](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)

```java
public MyList(int[] array)
```
Создаёт список из элементов массива. Если передан null, поведение должно быть эквивалентно конструктору по умолчанию