class Solution:
    def countValid(self, n, arr):
        arr_set = set(arr)
        all_digits = set(range(10))
        allowed_digits = list(all_digits - arr_set)
        m = len(allowed_digits)
        if n == 1:
            total = 9  
        else:
            total = 9 * (10 ** (n - 1))  
        if m == 0:
            return total  
        if 0 in allowed_digits:
            first_digit_choices = m - 1 
        else:
            first_digit_choices = m
        if first_digit_choices == 0:
            invalid = 0
        else:
            invalid = first_digit_choices * (m ** (n - 1))
        return total - invalid
