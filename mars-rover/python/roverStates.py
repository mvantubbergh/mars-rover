from typing import NamedTuple

currentX = 0
currentY = 0

def takeCoordinates(x,y) :
    currentX = currentX + x
    currentY = currentY + y

class StartingPosition :
    x = 0,
    y = 0

class MaxCoordintates(NamedTuple) :
    x : int
    y : int