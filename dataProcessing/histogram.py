import numpy as np
import matplotlib.pyplot as plt
import scipy.stats


def mean_confidence_interval(data, confidence=0.95):
    a = 1.0 * np.array(data)
    n = len(a)
    m, se = np.mean(a), scipy.stats.sem(a)
    h = se * scipy.stats.t.ppf((1 + confidence) / 2., n-1)
    return m, m-h, m+h


arr = np.loadtxt("data/single-s1.csv", delimiter=",", dtype='int16')

# ci95 = []
# ci99 = []
# for i in range(10, len(arr) + 1, 10):
#     ci95.append(mean_confidence_interval(arr[0:i]))
#     ci99.append(mean_confidence_interval(arr[0:i], 0.99))

# _ = plt.plot([i for i in range(10, len(arr) + 1, 10)], ci95)
# plt.show()


_ = plt.hist(arr, bins='auto')
plt.show()


