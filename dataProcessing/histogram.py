import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as st


arr = np.loadtxt("data/double-s2s1.csv", delimiter=",", dtype='int16')

probs = []
for i in range(10000):
    probs.append((1000 - np.sum(arr[1000*i:1000*i+1000]))/1000)

plt.figure(figsize=(9, 6), dpi=100)

_ = plt.hist(probs, bins=30)
plt.show()

print(1-np.mean(arr))
