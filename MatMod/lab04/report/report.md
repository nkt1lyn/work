---
# Front matter
title: "Отчет по лабораторной работе №4"
subtitle: "Модель гармонических колебаний"
author: "Ильин Никита Евгеньевич"
group: NFIbd-01-19
institute: RUDN University, Moscow, Russian Federation
date: 2022 Feb 10th

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

Цель работы научиться строить модели гармонических колебаний в OpenModelica.

# Задание
Вариант 10

Необходимо:

1. Построить фазовый портрет гармонического осциллятора и решение уравнения
гармонического осциллятора для следующих случаев:

    1. Колебания гармонического осциллятора без затуханий и без действий внешней
силы ${\ddot{x} + 7x = 0}$

    2. Колебания гармонического осциллятора c затуханием и без действий внешней
силы ${\ddot{x} + 9\dot{x} + 3x = 0}$

    3. Колебания гармонического осциллятора c затуханием и под действием внешней
силы ${\ddot{x} + 4\dot{x} + x = cos(2t)}$

На интервале $t \in [0; 30]$ (шаг 0.05) с начальными условиями $x_0 = 2, y_0 = 0$

# Теоретическое введение

Движение грузика на пружинке, маятника, заряда в электрическом контуре, а
также эволюция во времени многих систем в физике, химии, биологии и других
науках при определенных предположениях можно описать одним и тем же
дифференциальным уравнением, которое в теории колебаний выступает в качестве
основной модели. Эта модель называется линейным гармоническим осциллятором.
Уравнение свободных колебаний гармонического осциллятора имеет
следующий вид:

$${\ddot{x} + 2\gamma\dot{x} + \omega_0^2 x = 0}\quad\quad(1)$$

где x – переменная, описывающая состояние системы (смещение грузика, заряд
конденсатора и т.д.), $\gamma$– параметр, характеризующий потери энергии (трение в
механической системе, сопротивление в контуре), $\omega_0$– собственная частота
колебаний, t – время. (Обозначения ${\ddot{x} = \frac{\partial^2{T}}{\partial{x^2}}, \dot{x} = \frac{\partial{x}}{\partial{t}}}$

Уравнение (1) есть линейное однородное дифференциальное уравнение
второго порядка и оно является примером линейной динамической системы.
При отсутствии потерь в системе ( $\gamma = 0$ ) вместо уравнения (1.1) получаем
уравнение консервативного осциллятора энергия колебания которого сохраняется
во времени.
$${\ddot{x} + \omega_0^2 x = 0}\quad\quad(2)$$
Для однозначной разрешимости уравнения второго порядка (2) необходимо
задать два начальных условия вида:

$$
\begin{cases}
x(t_0) = x_0\\
\dot x (t_0) = y_0
\end{cases}
\quad\quad(3)
$$

Уравнение второго порядка (2) можно представить в виде системы двух
уравнений первого порядка:
$$
\begin{cases}
\dot x = x_0\\
\dot y = -\omega_0^2x
\end{cases}
\quad\quad(4)
$$
Начальные условия (3) для системы (4) примут вид:
$$
\begin{cases}
x(t_0) = x_0\\
y(t_0) = y_0
\end{cases}
\quad\quad(5)
$$
Независимые переменные x, y определяют пространство, в котором
«движется» решение. Это фазовое пространство системы, поскольку оно двумерно
будем называть его фазовой плоскостью.
Значение фазовых координат x, y в любой момент времени полностью
определяет состояние системы. Решению уравнения движения как функции
времени отвечает гладкая кривая в фазовой плоскости. Она называется фазовой
траекторией. Если множество различных решений (соответствующих различным
начальным условиям) изобразить на одной фазовой плоскости, возникает общая картина поведения системы. Такую картину, образованную набором фазовых траекторий, называют фазовым портретом.

# Выполнение лабораторной работы

1. Пишем программу для построения фазового портрета гармонического осциллятора без затуханий и без действий внешней силы:

![Код задачи №1](images/image001.png){ #fig:001 width=100% }  

2. Совершаем симуляцию со следующими настройками:  

![Настройки симуляции задачи №1](images/image002.png){ #fig:002 width=100% }  

3. Получаем следующий результат симуляции:  

![Результат симуляции задачи №1](images/image003.png){ #fig:003 width=100% }  

4. Изменяем программу для построения фазового портрета колебания гармонического осциллятора c затуханием и без действий внешней силы:  

![Код задачи №2](images/image005.png){ #fig:004 width=100% }  

5. Совершаем симуляцию со следующими настройками:  

![Настройки симуляции задачи №2](images/image002.png){ #fig:005 width=100% }  

6. Получаем следующий результат симуляции:  

![Результат симуляции задачи №2](images/image006.png){ #fig:006 width=100% }  
 
7. Изменяем программу для построения фазового портрета колебания гармонического осциллятора c затуханием и под действием внешней силы:  

![Код задачи №3](images/image008.png){ #fig:007 width=100% }  

8. Совершаем симуляцию со следующими настройками:  

![Настройки симуляции задачи №3](images/image002.png){ #fig:008 width=100% }  

9. Получаем следующий результат симуляции:  

![Результат симуляции задачи №3](images/image009.png){ #fig:009 width=100% }  
 

# Выводы

1. В ходе работы мы рассмотрели 3 типа колебаний гармонического осциллятора:

    1. Колебания гармонического осциллятора без затуханий и без действий внешней силы
    2. Колебания гармонического осциллятора c затуханием и без действий внешней силы
    3. Колебания гармонического осциллятора c затуханием и под действием внешней силы

2. Были построены модели, показывающие фазовый портрет гармонических колебаний для всех случаев


# Список литературы

1. Методические материалы курса
