# Glossary

# Методологии работы с неопределённостью
## BDUF 
_Big Design Up Front_ 
is a software development approach in which the program's design is to be completed and perfected before that program's implementation is started. It is often associated with the waterfall model of software development.
перезакладывание, например на большое количество юзеров
## KISS 
_Keep It Simple, Stupid_
is a principle states that most systems work best if they are kept simple rather than made complicated; therefore, simplicity should be a key goal in design, and unnecessary complexity should be avoided.
## YAGNI 
_You Aren’t Gonna Need It_
is a principle of extreme programming (XP) that states a programmer should not add functionality until deemed necessary. 
## Emergent Design 
предполагается возможность внесения изменений в любой точке по мере их появления. При таком подходе необходимо автотестирование (нужно заранее писать автотесты и прогонять их после внесения изменений), соответственно код обязан быть тестопригодным.

# Matrix vs. Feature teams
- Matrix teams _отдел разработки, отдел тестирования и т.д._
- Feature team _все роли в одной команде_

# Виды бизнес-моделей
- Заказная vs. Продуктовая _В продуктовой главная метрика – Time to Market (TTM), а также тиражируемость и инновационность продукта_
- In-House vs. Outsource

# Version Control Systems (VCS)
Примеры: SVN, GIT, Mercurial

# Distributed Version Control Systems (DVCS)
- is a type of version control where the complete codebase — including its full version history — is mirrored on every developer's computer
- _нет центрального хранилища (сервера), при сохранении кода он дублируется везде_
- Пример: GIT

# TDD 
 _"Test driven development"_
is an evolutionary approach to development which combines test-first development where you write a test before you write just enough production code to fulfill that test and refactoring.

# Технический долг
## Точка «Ж» 
уровень накопленного технического долга, после которого масштаб необходимых переработок по времени \ деньгам перестает оправдывать существование системы (проще выкинуть и написать заново)

# DevOps 
a set of practices that combines software development and information - technology operations

# Cap Theorem 
a concept that a distributed database system can only have 2 of the 3: Consistency, Availability, Partition Tolerance;

# Cherry Pick 
choose a commit from one branch and apply it onto another.

# Markdown
- Image: ![Image alt](https://raw.githubusercontent.com/Gregwar/Image/master/images/error.jpg)


# Виды требований с ПО
## Functional requirements 
требования к функциональному наполнению системы \ продукта (что ПО должно уметь делать и какие задачи выполнять)

## Non-functional requirements 
требования к атрибутам качества системы \ продукта (какими характеристиками ПО должно обладать, чтобы оптимально соответствовать функциональным требованиям)

## Внешние требования 
требования к системе \ продукты со стороны заказчика или пользователя

## Внутренние требования 
требования к системе \ продукту со стороны команды разработки 

# Параметры качества кода
## «Говнокод» 
некое эфемерное понятие о коде, который не соответствует чувству прекрасного у конкретной команды или индивидуального разработчика, часто не поддается четкому и структурированному описанию с точки зрения конкретных характеристик

## WTF/Sec 
мера измерения качества кода (количество вопросительных восклицаний за единицу времени прочтения)

# Цикл Колба 
модель обучения взрослых, при котором поэтапно происходит переход от неосознанной некомпетентности к осознанной некомпетентности к осознанной компетентности к неосознанной компетентности и обратно в неосознанную некомпетентность. Все люди проходят по всем квадрантам ровно в указанной последовательности и «говорить» находясь в разные бывает крайне сложно.

# Элементы разработки ПО
## API (application program interface)
интерфейс приложения, доступный для внешнего использования другим ПО 

## Repository
библиотеки, хранящие готовые куски кода, выполняющего определённую функциональность

## Framework
набор инструментов для конкретного языка разработки, позволяющий упрощать \ ускорять программирование на нем

## VM (virtual machine)
программная «прослойка» между операционной системой и приложением, написанном на конкретном языке, облегчающая их запуск и интеграцию в OS
