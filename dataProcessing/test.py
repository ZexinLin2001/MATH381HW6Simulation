import numpy as np

for i in range(1, 7):
    for j in range(1, 7):
        arr = np.loadtxt("data/double-s" + str(i) + "s" + str(j) + ".csv", delimiter=",", dtype='int16')
        print(1-np.mean(arr))