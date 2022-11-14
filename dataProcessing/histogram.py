import numpy as np
import matplotlib.pyplot as plt

num = 3

arr = np.loadtxt("data/single-s" + str(num) + ".csv", delimiter=",", dtype='int16')

_ = plt.hist(arr, bins=200)
# plt.axvline(x=np.mean(arr), color='k')
plt.xlabel("Rolls till finish")
plt.ylabel("Number of games")
plt.title("Single Player with Strategy " + str(num) + ", 10^6 simulations")


plt.show()