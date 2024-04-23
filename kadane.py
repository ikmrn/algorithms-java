from sys import maxsize

array = [4, -1, 2, -7, 3, 4]

# Return 2 pointer start and end for an subarray of max sum


def kadane(arr):
    max_sum = arr[0]
    curr_sum = 0
    L_max = 0
    R_max = 0
    L = 0

    for R, value in enumerate(arr):
        if curr_sum < 0:
            L = R
            curr_sum = 0
        curr_sum += value
        if curr_sum > max_sum:
            L_max = L
            R_max = R
            max_sum = curr_sum
    return [L_max, R_max]


print(kadane(array))
