import sys
import math
import pathfinder
import random
import numpy as np

def readpath(pathtxt):
    # read result map
    pathmap = []
    for i, line in enumerate(pathtxt):
        pathmap.append([])
        currentnum = 0
        for char in line:
            if char.isdigit():
                currentnum = currentnum * 10 + int(char)
            elif char == 'X':
                currentnum = -1
            elif char == '*':
                currentnum = -2
            else:
                pathmap[i].append(currentnum)
                currentnum = 0

    # BECAUSE TXT END: add the last number in the matrix
    pathmap[len(pathmap) - 1].append(currentnum)

    # record path
    path = []
    for i, line in enumerate(pathmap):
        for j, num in enumerate(line):
            if num == -2:
                path.append((i, j))

    return path

def randomBFS(map, path, d):
    # randomly pick a section on the path
    pathindex = random.randint(0, len(path) - 1)
    (u, v) = path[pathindex]
    (x, y) = (-1, -1)
    endindex = -1
    if pathindex + d < len(path):
        endindex = pathindex + d
        (x, y) = path[pathindex + d]
    else:
        endindex = len(path) - 1
        (x, y) = path[len(path) - 1]

    # copy path
    newpath = []
    for point in path:
        newpath.append(point)

    # random bfs from start to end
    queue = [(u, v)]
    parent = {(u, v): (u, v), newpath[pathindex - 1]: newpath[pathindex - 1]}

    #print('start point: (' + str(u) + ', ' + str(v) + ')')
    #print('end point: (' + str(x) + ', ' + str(y) + ')')

    while queue:
        currentpos = queue.pop(0)
        row, column = currentpos
        directions = [(row - 1, column), (row + 1, column), (row, column - 1), (row, column + 1)]
        #print(directions)

        while directions:
            direction = random.randint(0, len(directions) - 1)
            (i, j) = directions[direction]
            if 0 <= i < len(map) and 0 <= j < len(map[i]) and (i, j) not in parent and map[i][j] != -1:
                #print('direction: ', end = '')
                #print((i, j))
                queue.append((i, j))
                parent[(i, j)] = currentpos
                # found end point
                if (i, j) == (x, y):
                    #print(parent)
                    current = (x, y)
                    currentindex = endindex
                    while parent[current] != current:
                        currentindex -= 1
                        newpath[currentindex] = parent[current]
                        current = parent[current]
                        '''print('index = ' + str(currentindex))
                        print('newpath[' + str(endindex) + '] = ' + str(newpath[currentindex]))
                        '''
                    #print(newpath)
                
                    return (pathindex, endindex, newpath)

            directions.pop(direction)

    return (pathindex, endindex, newpath)

def calculatepath(startindex, endindex, path, newpath, map):
    oldcost = 0
    newcost = 0
    
    for i in range(startindex + 1, endindex):
        oldcost += pathfinder.getcost(path[i - 1], path[i], map)

    for i in range(startindex + 1, endindex):
        newcost += pathfinder.getcost(newpath[i - 1], newpath[i], map)

    return (oldcost, newcost)
        
def printoutput(path, map):
    path = set(path)
    # print matrix with result route
    for i, row in enumerate(map):
        for j, num in enumerate(row):
            if (i, j) in path:
                print('*', end = '')
            else:
                if num != -1:
                    print(num, end = '')
                elif num == -1:
                    print('X', end = '')
            if j != len(map[i]) - 1:
                print(' ', end = '')

        print('')


def simulatedAnnealing(map, path, Tini, Tfin, alpha, d):
    temparatures = []
    costs = []
    while Tini > Tfin:
        startindex, endindex, newpath = randomBFS(map, path, d)
        oldcost, newcost = calculatepath(startindex, endindex, path, newpath, map)
        cost = oldcost
        if newcost < oldcost:
            path = newpath
            cost = newcost
        else:
            probability = np.expm1((newcost - oldcost) / Tini) / np.expm1(1.0 / Tini)
            if probability > random.uniform(0, 1):
                path = newpath
                cost = newcost

        temparatures.append(Tini)
        costs.append(cost)

        Tini *= alpha

    printoutput(path, map)
    for i in range(len(temparatures)):
        print('T = ' + str(temparatures[i]) + ', cost = ' + str(costs[i]))


if __name__ == '__main__':
    # read arguments from command line
    maptxt = open(sys.argv[1])
    start, end, map = pathfinder.readmap(maptxt)
    pathtxt = open(sys.argv[2])
    path = readpath(pathtxt)
    Tini = float(sys.argv[3])
    Tfin = float(sys.argv[4])
    alpha = float(sys.argv[5])
    d = int(sys.argv[6])

    simulatedAnnealing(map, path, Tini, Tfin, alpha, d)