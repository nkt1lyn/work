---
# Front matter
title: "Лабораторная работа 3. Моделирование стохастических процессов"
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

Научиться разрабатывать сценарий, реализующий модель стохастических процессов

# Ход работы

1. Реализую модель на NS-2, с помощью кода, представленного в задании

![Рис 1. Код программы(1)](images/img(1).png)

![Рис 2. Код программы(2)](images/img(2).png)

2. Запускаю файл:

      ns lab03.tcl

  ![Рис 3. Результат работы программы](images/photo_2022-04-30_11-36-13.jpg)


2. Создаю файл graph в каталоге с проектом. Добавляю код, предоставленный в задании, соблюдая синтаксис.

  Создание файла:

        touch graph

  Делаю файл исполняемым:

        chmod +x graph

  Добавляю в файл код программы:

![Рис 4. Код программы GNUplot](images/img(3).png)

3. Запускаю программу с помощью команды

        ./graph

  Результат выполнения программы:

![Рис 5. График №1 - Результат выполнения программы](images/img(4).png)

# Выводы

Получены навыки работы с ns2 в связке с GNUplot

# Библиография

1. Методические материалы курса