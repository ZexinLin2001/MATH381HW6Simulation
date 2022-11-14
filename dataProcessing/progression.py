import numpy as np
import matplotlib.pyplot as plt
import scipy.stats

def mean_confidence_interval(data, confidence=0.95):
    a = 1.0 * np.array(data)
    n = len(a)
    m, se = np.mean(a), scipy.stats.sem(a)
    h = se * scipy.stats.t.ppf((1 + confidence) / 2., n-1)
    return m, m-h, m+h


num = 1

arr = np.loadtxt("data/single-s" + str(num) + ".csv", delimiter=",", dtype='int16')

means = []
ci95 = []
ci99 = []
for i in range(10, len(arr)//100 + 1, 10):
    mean, ci95l, ci95h = mean_confidence_interval(arr[0:i])
    mean, ci99l, ci99h = mean_confidence_interval(arr[0:i], 0.99)
    means.append(mean)
    ci95.append([ci95l, ci95h])
    ci99.append([ci99l, ci99h])

fig, ax = plt.plot([i for i in range(10, len(arr)//100 + 1, 10)], ci95, color='b')
plt.plot([i for i in range(10, len(arr)//100 + 1, 10)], ci99, color='r')
plt.plot([i for i in range(10, len(arr)//100 + 1, 10)], means, color='k')

plt.xlabel("Number of games")
plt.ylabel("Value of ...")
plt.legend(["95CI low", "95CI high", "99CI low", "99CI high", "mean"])
plt.title("Single Player with Strategy " + str(num) + ", first 10^4 of 10^6 simulations")

plt.show()

print(scipy.stats.describe(arr))

# s1: DescribeResult(nobs=1000000, minmax=(26, 157), mean=64.477177, variance=151.03100014167106, skewness=0.6474048123612509, kurtosis=0.7619243597145222)
# s2: DescribeResult(nobs=1000000, minmax=(23, 149), mean=63.696428, variance=142.2508562916724, skewness=0.645568122548458, kurtosis=0.768070487884335)
# s3: DescribeResult(nobs=1000000, minmax=(21, 147), mean=50.550289, variance=98.39289140937043, skewness=0.8317789353822028, kurtosis=1.385522062944795)