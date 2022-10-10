import sys
from io import TextIOWrapper

from roverStates import MaxCoordintates, takeCoordinates, StartingPosition

input_consequences = {
    "N" : {
        "L" : "E",
        "R" : "W",
        "M" : takeCoordinates(0, 1)
    },

    "E" : {
        "L" : "S",
        "R" : "N",
        "M" : (1, 0)
    },

    "S" : {
        "L" : "W",
        "R" : "E",
        "M" : (0, -1)
    },

    "W" : {
        "L" : "N",
        "R" : "S",
        "M" : (-1, 0)
    }
}

def start (upperBounds : MaxCoordintates, startCoordinates : StartingPosition,  commands : string) :
    