test1 = [
    [1, 0, 0, 1, 0],
    [1, 0, 1, 0, 0],
    [0, 0, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 0],
]
test2 = [[0]]
test3 = [[1]]
test4 = [[1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0]]
test5 = [[1, 0, 0, 1], [1, 0, 1, 0], [0, 0, 1, 0], [1, 0, 1, 0]]

dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]


def walk(matrix, r, c, seen, arr, count, first):
    if r < 0 or r > len(matrix) - 1 or c < 0 or c > len(matrix[0]) - 1:
        return False
    if matrix[r][c] == 0:
        return False
    if seen[r][c]:
        return False
    seen[r][c] = True
    count[0] += 1
    for d in dirs:
        y, x = d
        walk(matrix, r + y, c + x, seen, arr, count, False)
    if first:
        arr.append(count[0])


def riverSizes(matrix):
    list_result = []
    rows = len(matrix)
    cols = len(matrix[0])
    seen = [[False] * cols for _ in range(rows)]
    for r in range(rows):
        for c in range(cols):
            walk(matrix, r, c, seen, list_result, [0], True)
    return list_result


print(riverSizes(test1))
print(riverSizes(test2))
print(riverSizes(test3))
print(riverSizes(test4))
print(riverSizes(test5))
