# Link to the problem https://www.algoexpert.io/questions/validate-subsequence


def isValidSubsequence(array, sequence):
    # Write your code here.
    count = 0
    for item in array:
        if item == sequence[count]:
            count += 1
            if count == len(sequence):
                return True
    return False


array = [5, 1, 22, 25, 6, -1, 8, 10]
sequence = [1, 6, -1, 10]
print(isValidSubsequence(array, sequence))

array = [5, 1, 22, 25, 6, -1, 8, 10]
sequence = [1, 6, -1, 10, 5]
print(isValidSubsequence(array, sequence))
