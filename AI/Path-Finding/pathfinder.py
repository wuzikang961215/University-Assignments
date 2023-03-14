import sys
import math

def readmap(maptxt):
    start = [-1, -1]
    end = [-1, -1]
    map = []
    for i, line in enumerate(maptxt):
        # read start and end index
        if i == 1 or i == 2:
            currentnum = 0
            row = -1
            index = 0
            for char in line:
                if char.isdigit():
                    currentnum = currentnum * 10 + int(char)
                else:
                    if i == 1:
                        start[index] = currentnum - 1
                    if i == 2:
                        end[index] = currentnum - 1
                    currentnum = 0
                    index += 1

        # read matrix
        elif i > 2:
            map.append([])
            currentnum = 0
            for char in line:
                if char.isdigit():
                    currentnum = currentnum * 10 + int(char)
                elif char == 'X':
                    currentnum = -1
                else:
                    map[i - 3].append(currentnum)
                    currentnum = 0

    # BECAUSE TXT END: add the last number in the matrix
    map[len(map) - 1].append(currentnum)
        
    return (tuple(start), tuple(end), map)

def trackroute(pos, parent, map):
    # copy map
    copy = []
    for row in map:
        copy.append(row)

    # track from end to start point
    while parent[pos] != pos:
        row, column = pos
        copy[row][column] = '*'
        pos = parent[pos]

    # set start point '*'
    i, j = pos
    copy[i][j] = '*'

    # print matrix with result route
    for i, row in enumerate(copy):
        for j, num in enumerate(row):
            if num != -1:
                print(num, end = '')
            elif num == -1:
                print('X', end = '')
            if j != len(copy[i]) - 1:
                print(' ', end = '')
        if i != len(copy) - 1:
            print('')
        

def bfs(start, end, map):
    # initialize a queue and a parent hashmap
    queue = [start]
    parent = {start: start}

    # keep searching
    while queue:
        currentpos = queue.pop(0)
        row, column = currentpos
        # explore from up, down, left and right
        for (i, j) in [(row - 1, column), (row + 1, column), (row, column - 1), (row, column + 1)]:
            if 0 <= i < len(map) and 0 <= j < len(map[i]) and (i, j) not in parent and map[i][j] != -1:
                queue.append((i, j))
                parent[(i, j)] = currentpos
                # found end point
                if (i, j) == end:
                    trackroute(end, parent, map)
                    return

    print('null')

def getcost(currentpos, nextpos, map):
    currentrow, currentcol = currentpos
    nextrow, nextcol = nextpos
    # stay level or slide downhill
    if map[nextrow][nextcol] <= map[currentrow][currentcol]:
        return 1

    else:
        return 1 + map[nextrow][nextcol] - map[currentrow][currentcol]


def ucs(start, end, map):
    # initialize a queue and a parent map
    # queue consists of (currentpos, cost)
    queue = [(start, 0)]
    parent = {start: start}

    while queue:
        # find smallest in the queue
        currentcost, queueindex = (float('inf'), -1)
        for i, pair in enumerate(queue):
            pos, cost = pair
            if cost < currentcost:
                queueindex = i
                currentcost = cost
        currentpos, currentcost = queue.pop(queueindex)
        row, column = currentpos
        
        if currentpos == end:
            trackroute(end, parent, map)
            return
        row, column = currentpos
        # search all neighbors
        for (i, j) in [(row - 1, column), (row + 1, column), (row, column - 1), (row, column + 1)]:
            if 0 <= i < len(map) and 0 <= j < len(map[i]) and (i, j) not in parent and map[i][j] != -1:
                # push the total distance so far
                queue.append(((i, j), currentcost + getcost(currentpos, (i, j), map)))
                parent[(i, j)] = currentpos

    print('null')


def astar(start, end, map, heuristic):
    # initialize a queue and a parent map
    # queue consists of (currentpos, cost, heuristic)
    queue = [(start, 0, 0)]
    parent = {start: start}
    endrow, endcol = end

    while queue:
        # find smallest in the queue
        currentcost, queueindex = (float('inf'), -1)
        for i, pair in enumerate(queue):
            pos, cost, heu = pair
            if cost + heu < currentcost:
                queueindex = i
                currentcost = cost + heu
        currentpos, currentcost, currentheu = queue.pop(queueindex)
        row, column = currentpos
        
        if currentpos == end:
            trackroute(end, parent, map)
            return
        row, column = currentpos
        # search all neighbors
        for (i, j) in [(row - 1, column), (row + 1, column), (row, column - 1), (row, column + 1)]:
            if 0 <= i < len(map) and 0 <= j < len(map[i]) and (i, j) not in parent and map[i][j] != -1:
                heu = -1
                # get heuristic distance
                if heuristic == 'manhattan':
                    heu = abs(i - endrow) + abs(j - endcol)
                elif heuristic == 'euclidean':
                    heu = math.sqrt(pow(i - endrow, 2) + pow(j - endcol, 2))
                # push the total distance so far
                queue.append(((i, j), currentcost + getcost(currentpos, (i, j), map), heu))
                parent[(i, j)] = currentpos

    print('null')

if __name__ == '__main__':
    # read arguments from command line
    maptxt = open(sys.argv[1])
    start, end, map = readmap(maptxt)
    algorithm = sys.argv[2]
    if len(sys.argv) > 3:
        heuristic = sys.argv[3]

    # choice of different algorithms
    if algorithm == 'bfs':
        bfs(start, end, map)
    elif algorithm == 'ucs':
        ucs(start, end, map)
    elif algorithm == 'astar':
        astar(start, end, map, heuristic)
