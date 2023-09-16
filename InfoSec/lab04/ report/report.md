---
# Front matter
title: "Лабораторная работа № 4. Дискреционное разграничение прав в Linux. Расширенные атрибуты"
author: "Ильин Никита Евгеньевич, НФИбд-01-19"

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

Получение практических навыков работы в консоли с расширенными атрибутами файлов

# Последовательность выполнения работы

1. От имени пользователя guest определите расширенные атрибуты файла /home/guest/dir1/file1 командой

lsattr /home/guest/dir1/file1

2. Установите командой

chmod 600 file1

на файл file1 права, разрешающие чтение и запись для владельца файла.


3. Попробуйте установить на файл /home/guest/dir1/file1 расширенный атрибут a от имени пользователя guest:

chattr +a /home/guest/dir1/file1

В ответ вы должны получить отказ от выполнения операции. (рис. -@fig:001)

 ![Отказ](images/img3.png){#fig:1 width=100%}

4. Зайдите на третью консоль с правами администратора либо повысьте свои права с помощью команды su. Попробуйте установить расширенный атрибут a на файл /home/guest/dir1/file1 от имени суперпользователя:

chattr +a /home/guest/dir1/file1 (рис. -@fig:002)

![установка расширенного атрибута](images/img4.png){ #fig:002 width=70% }

5. От пользователя guest проверьте правильность установления атрибута:

lsattr /home/guest/dir1/file1

6. Выполните дозапись в файл file1 слова «test» командой

echo "test" /home/guest/dir1/file1

После этого выполните чтение файла file1 командой

cat /home/guest/dir1/file1

Убедитесь, что слово test было успешно записано в file1.

7. Попробуйте удалить файл file1 либо стереть имеющуюся в нём информацию командой

echo "abcd" > /home/guest/dirl/file1

Попробуйте переименовать файл.

8. Попробуйте с помощью команды

chmod 000 file1

установить на файл file1 права, например, запрещающие чтение и запись для владельца файла. Удалось ли вам успешно выполнить указанные команды? (рис. -@fig:003)

![установка прав](images/img7.png){ #fig:003 width=70% }


9. Снимите расширенный атрибут a с файла /home/guest/dirl/file1 от
имени суперпользователя командой

chattr -a /home/guest/dir1/file1

Повторите операции, которые вам ранее не удавалось выполнить. Ваши
наблюдения занесите в отчёт. (рис. -@fig:004)

![повторение операций](images/img8.png){ #fig:004 width=70% }

Теперь нам нужно повторить операции, которые ранее не удалось сделать.

Выполните дозапись в файл file1 слова «test» командой

echo "test" /home/guest/dir1/file1

После этого выполните чтение файла file1 командой

cat /home/guest/dir1/file1

Убедитесь, что слово test было успешно записано в file1.

Попробуйте удалить файл file1 либо стереть имеющуюся в нём информацию командой

echo "abcd" > /home/guest/dirl/file1

Попробуйте переименовать файл.

Попробуйте с помощью команды

chmod 000 file1

установить на файл file1 права, например, запрещающие чтение и запись для владельца файла. Удалось ли вам успешно выполнить указанные команды? (рис. -@fig:005)

![установка прав](images/img10.png){ #fig:005 width=70% }

10. Повторите ваши действия по шагам, заменив атрибут «a» атрибутом «i».
Удалось ли вам дозаписать информацию в файл? Ваши наблюдения занесите в отчёт

10.1 Установите командой

chmod 600 file1

на файл file1 права, разрешающие чтение и запись для владельца файла.

10.2 Попробуйте установить расширенный атрибут a на файл /home/guest/dir1/file от имени суперпользователя:

chattr +i /home/guest/dir1/file (рис. -@fig:006)

![Установка расширенного атрибута](images/img12.png){ #fig:006 width=70% }

10.3 От пользователя guest проверьте правильность установления атрибута:

lsattr /home/guest/dir1/file

10.4 Выполните дозапись в файл file слова «test» командой

echo "test2" /home/guest/dir1/file

После этого выполните чтение файла file командой

cat /home/guest/dir1/file

10.5 Попробуйте удалить файл file1 либо стереть имеющуюся в нём информацию командой

echo "abcdefg" > /home/guest/dirl/file

Попробуйте переименовать файл.

10.6 Попробуйте с помощью команды

chmod 000 file1

установить на файл file1 права, например, запрещающие чтение и запись для владельца файла.

10.7 Снимите расширенный атрибут i с файла /home/guest/dirl/file1 от
имени суперпользователя командой

chattr -i /home/guest/dir1/file1

# Выводы

Получили практические навыкы работы в консоли с расширенными
атрибутами файлов.

# Выводы

Получены пракические навыки работы в консоли с атрибутами файлов, закреплены теоретические основы дискреционного разграничения доступа в современных системах на базе ОС Linux.

# Библиография

1. Методические материалы курса