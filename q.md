==Question 1
How many times will the word "hello" appear?

c = 5
a = 7
b = 8
c = b - c

for i in range(0, c):
    print("hello")

a) 5
b) 7
c) 8
d) 3

==Question 2
A ladybug has two methods: move(), which moves her one space in the direction she's facing, and rotate(), which rotates the direction she's facing 90 degrees clockwise.

If the ladybug is on a board like the one below, what instruction would you need to use to get the ladybug from point A (where she sits looking North) to point B.

. . . . .
.A. .X.X.
.X. . .X.
.X.X. .B.

*a) rotate, move, rotate, move, rotate x3, move, rotate, move, rotatex3
b) rotatex3, move, rotate, move, rotate x3, move, rotate, move, rotate
c) move, rotate, move, rotate, move x3, rotate, move
d) rotate, move x2, rotate, move, rotate, move

==Question 3
You have a program like the one below. What would be returned if you call F(3)?

def F(n):
    if n == 0: return 0
    elif n == 1: return 1
    else: return F(n-1)+F(n-2)

*a) 2
b) 1
c) 3
d) 5

==Question 4
Which of these is used as an escape character in strings?

a) /
b) \
c) '
d) "

==Question 5
What will c be equal to at the end of this program?

a = 3
b = 2
c = a + b
b = 4
a = a + b
c = c + a

*a) 12
b) 5
c) 10
d) 7

==Question 6
What will c be equal to at the end of this program?

a = 4
b = 5
c = a
d = c

if (a + 2 > b + 1):
    c = 2 * c
else:
    c = c / 2

a) 2
b) 4
c) 5
d) 3

==Question 7
What will print?

a = "foo"
b = "bar"
c = " "
d = a + b + c + a + b
print("d")

a) d
b) foobar foobar
c) foobarfoobar
d) foobar

==Question 8
What will print?

a = "foo"
b = "bar"
c = " "
d = a + b + c + a + b
print(d)

a) d
b) foobar foobar
c) foobarfoobar
d) foobar

==Question 9
What will print?

a = 5
b = 5

if (a - b < 0):
    print("foo")
elif (5 == 6):
    print("baf")
elif (7 == 8):
    print("bof")
else:
    print("bar")

a) foo
b) bar
c) baf
d) bof

==Question 10
What will the following code print?

mystring = "Hello"
mystring += " world."
print mystring

a) Hello World.
b) Helloworld.
c) Hello
d)  wolrd.