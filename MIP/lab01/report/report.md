---
# Front matter
title: "Лабораторная работа 1. Простые модели компьютерной сети"
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

Приобретение навыков моделирования сетей передачи данных с помощью сред-
ства имитационного моделирования NS-2, а также анализ полученных результатов
моделирования.

# Ход работы

1. В своем рабочем каталоге создаем директорию mip, в которой будут выполнять лабораторные работы. Внутри нее создаем директорию lab-ns, а в ней файл shablon.tcl.

![Рис 1. Создание директории](images/image007.png)

2. Пишем программу в файл shablon.tcl.

![Рис 2. Код программы для шаблона](images/image001.png)

3. Пишем программу для моделирования простой сети в файл example1.tcl.

![Рис 2. Код программы для моделирования простой сети](images/image002.png)

4. Запускаем моделирование с помощью команды nam out.nam.

![Рис 3. Моделирование простой сети из двух узлов ](images/image008.png)

5. Пишем программу для усложненной сети из четырех узлов в файл example2.tcl.

![Рис 4. Код программы для усложненной сети из четырех узлов(1) ](images/image003.png)

![Рис 5. Код программы для усложненной сети из четырех узлов(2) ](images/image004.png)

6. Запускаем моделирование с помощью команды nam out.nam

![Рис 6. Моделирование усложненной сети](images/image009.png)

7. Пишем программу для моделирования кольцевой сети в файл example3.tcl.

![Рис 7. Код программы для кольцевой сети](images/image005.png)

8. Запускаем моделирование с помощью команды nam out.nam

![Рис 7. Моделирование простой сети из двух узлов ](images/image011.png)

9. Выполняем упражнение, записывая код в файл example4.tcl.

![Рис 8. Код программы для упражнения ](images/image006.png)

9. Запускаем моделирование с помощью команды nam out.nam

![Рис 9. Результат моделирования для упражнения ](images/image013.png)

# Выводы

Получены навыки моделирования сетей передачи данных в NS-2.

# Библиография

1. Методические материалы курса