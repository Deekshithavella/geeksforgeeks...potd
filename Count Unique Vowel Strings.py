from collections import defaultdict
from math import factorial
from functools import reduce
from operator import mul
class Solution:
    def vowelCount(self, s):
        vowels = {'a', 'e', 'i', 'o', 'u'}
        vowel_counts = defaultdict(int)
        for ch in s:
            if ch in vowels:
                vowel_counts[ch] += 1

        unique_vowels = list(vowel_counts.keys())
        num_unique = len(unique_vowels)
        if num_unique == 0:
            return 0
        total_combinations = reduce(mul, (vowel_counts[v] for v in unique_vowels), 1)
        total_permutations = factorial(num_unique)
        return total_combinations * total_permutations
