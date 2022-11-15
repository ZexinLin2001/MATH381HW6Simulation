import numpy as np
import matplotlib.pyplot as plt
import scipy.stats

def mean_confidence_interval(data, confidence=0.95):
    a = 1.0 * np.array(data)
    n = len(a)
    m, se = np.mean(a), scipy.stats.sem(a)
    h = se * scipy.stats.t.ppf((1 + confidence) / 2., n-1)
    return m, m-h, m+h


num = 3

arr = np.loadtxt("../data/single-s" + str(num) + ".csv", delimiter=",", dtype='int16')

means = []

for i in range(10):
    temp = []
    for j in range(1000):
        temp.append(np.mean(arr[10000 * i: 10000 * i + j + 1]))
    means.append(temp)

means = np.array(means)
means = np.transpose(means)

plt.figure(figsize=(9, 6), dpi=100)
_ = plt.plot([i for i in range(1000)],means, color='k')


plt.xlabel("Number of games")
plt.ylabel("Expectation Game Length")
plt.title("Expectation of Single Player with Strategy " + str(num) + " of 10 runs of 1000 simulations")

plt.show()
