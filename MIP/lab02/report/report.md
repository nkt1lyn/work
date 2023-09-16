---
# Front matter
title: "Лабораторная работа 2. Исследование протокола TCP и алгоритма управления очередью RED"
author: "Ильин Никита Евгеньевич"

# Generic otions
lang: ru-RU
toc-title: "Содержание"

# Pdf output format
toc: true # Table of contents
toc_depth: 2
lof: true # List of figures
lot: true # List of tables
fontsize: 12pt
linestretch: 1.5
papersize: a4
documentclass: scrreprt
## I18n
polyglossia-lang:
  name: russian
  options:
	- spelling=modern
	- babelshorthands=true
polyglossia-otherlangs:
  name: english
### Fonts
mainfont: PT Serif
romanfont: PT Serif
sansfont: PT Sans
monofont: PT Mono
mainfontoptions: Ligatures=TeX
romanfontoptions: Ligatures=TeX
sansfontoptions: Ligatures=TeX,Scale=MatchLowercase
monofontoptions: Scale=MatchLowercase,Scale=0.9
## Biblatex
biblatex: true
biblio-style: "gost-numeric"
biblatexoptions:
  - parentracker=true
  - backend=biber
  - hyperref=auto
  - language=auto
  - autolang=other*
  - citestyle=gost-numeric
## Misc options
indent: true
header-includes:
  - \linepenalty=10 # the penalty added to the badness of each line within a paragraph (no associated penalty node) Increasing the value makes tex try to have fewer lines in the paragraph.
  - \interlinepenalty=0 # value of the penalty (node) added after each line of a paragraph.
  - \hyphenpenalty=50 # the penalty for line breaking at an automatically inserted hyphen
  - \exhyphenpenalty=50 # the penalty for line breaking at an explicit hyphen
  - \binoppenalty=700 # the penalty for breaking a line at a binary operator
  - \relpenalty=500 # the penalty for breaking a line at a relation
  - \clubpenalty=150 # extra penalty for breaking after first line of a paragraph
  - \widowpenalty=150 # extra penalty for breaking before last line of a paragraph
  - \displaywidowpenalty=50 # extra penalty for breaking before last line before a display math
  - \brokenpenalty=100 # extra penalty for page breaking after a hyphenated line
  - \predisplaypenalty=10000 # penalty for breaking before a display
  - \postdisplaypenalty=0 # penalty for breaking after a display
  - \floatingpenalty = 20000 # penalty for splitting an insertion (can only be split footnote in standard LaTeX)
  - \raggedbottom # or \flushbottom
  - \usepackage{float} # keep figures where there are in the text
  - \floatplacement{figure}{H} # keep figures where there are in the text
---

# Цель работы

Научиться разрабатывать сценарий, реализующий модель сети. Исследовать протокол TCP и алгоритм управления очередью RED.

# Ход работы

1. Требуется разработать сценарий, реализующий модель согласно рис. 2.4, по-
строить в Xgraph график изменения TCP-окна, график изменения длины очереди
и средней длины очереди.

![Рис 1. Схема сети](images/lab02.jpg)

2. Копирую содержимое файла shablon.tcl(создан при выполнении lab01) в файл lab02_1.tcl. Добавляю в файл код, предоставленный в задании к лаб. работе.

![Рис 2. Код программы(1)](images/img(1).png)

![Рис 3. Код программы(2)](images/img(2).png)

![Рис 4. Код программы(3)](images/img(3).png)

3. Запускаю программу с помощью команды

        ns lab02_1.tcl

  Результат выполнения программы:

![Рис 5. График №1 - Динамика размера окна TCP](images/img(5).png)

![Рис 6. График №2 - Динамика очереди и средней длины очереди](images/img(4).png)

4. В упражнении требуется изменить тип протоколов на Newreno и Vegas. На скриншоте ниже представлены графики для трех разных типов протоколов.

    Первый стобец - Протокол Vegas

    Второй столбец - Протокол Newreno

    Третий столбец - Протокол Reno

![Рис 7. Графики для каждого протокола](images/img(7).png)

5. Также в упражнении было необходимо внести изменения при отображении окон. Через Xgraph, установленный в образе, предоставленном нам, это сделать невозможно, т.к. там очень старая версия. Я попробовал установить Xgraph последней версии в своих системах Ubuntu 22 и Windows 11, но так и не удалось заставить это работать через команду ns. Если открыть файл через Xgraph самостоятельно, то в опциях возможно изменить все необходимые параметры, кроме цвета траекторий. Для изменения цвета траекторий я нашел способ, но у меня не получилось запустить его.

![Рис 8. График с измененными характеристиками отображения](images/img(6).png)

# Выводы

Получены навыки работы с ns2 в связке с Xgraph

# Библиография

1. Методические материалы курса