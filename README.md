# Опис застосунку 
Ця програма перетворює синтаксис Markdown у відповідні теги HTML і Ansi. Він визначає абзаци та переформатовані частини тексту, замінюючи їх відповідними тегами, а також розпізнає жирний шрифт, курсив і моноширинний текст.
## Як запустити цю програму?
У вас повинен бути встановлений JDK17 або вище.
1. Клонуйте цей репозиторій за допомогою команди:
```
git clone https://github.com/karoll1naa/GitBasics2
```
2. Відкрийте термінал і перейдіть до каталогу src\main\org\example за допомогою команди:
```
cd src\main\java\org\example
```
3. Скомпілюйте код, щоб переконатися, що програма працюватиме правильно, використовуючи команду:
```
javac Main.java
```
4. Щоб полегшити роботу з програмою, я додала файли прикладів (такі як testText.txt, testAnsi.ansi та testHTML.html). Щоб конвертувати Markdown у HTML у файл, ви можете використати цю команду:
```
java Main.java testText.txt testHTML.html --format html
```
5. Щоб конвертувати Markdown у HTML у консоль, ви можете використати цю команду:

```
java Main.java testText.txt - --format html
```
Щоб перетворити Markdown на Ansi у консоль, ви можете використати цю команду:

```
java Main.java testText.txt - --format ansi
```
Щоб перетворити Markdown на Ansi у файл, ви можете використати цю команду:
```
java Main.java testText.txt testAnsi.ansi --format ansi
```
Щоб запустити модульні тести, ви можете використовувати цю команду:
```
./gradlew test
```
# Link
Revert commit: [https://github.com/karoll1naa/GitBasics2/commit/b787ba7c30b73e6b4a0345722daf42110badf67b](https://github.com/karoll1naa/GitBasics2/commit/b787ba7c30b73e6b4a0345722daf42110badf67b)
# Посилання на падіння тестів
[https://github.com/karoll1naa/GitBasics2/commit/d642cf6e45986bb8272170828b34470718c58829](https://github.com/karoll1naa/GitBasics2/commit/d642cf6e45986bb8272170828b34470718c58829)
# Висновок
Особисто для мене unit-тести не стали чимось корисним і класним, тому що корректність працездатності програми я перевіряю відразу під час написання коду і звіряю зі своїми очікуваними результати. А у цій ситуації, я знала, що методи працюють вірно і написання тестів по суті було не потрібним.
