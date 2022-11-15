import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as st


def mean_confidence_interval(data, confidence=0.95):
    a = 1.0 * np.array(data)
    n = len(a)
    m, se = np.mean(a), st.sem(a)
    h = se * st.t.ppf((1 + confidence) / 2., n-1)
    return m, m-h, m+h

def mean_ci(data, confidence):
    return st.t.interval(alpha=confidence,
              df=len(data)-1,
              loc=np.mean(data), 
              scale=st.sem(data))

num = 1

arr = np.loadtxt("../data/single-s" + str(num) + ".csv", delimiter=",", dtype='int16')

mean1000 = []

for i in range(10000):
    mean1000.append(np.mean(arr[1000*i:1000*i+1000]))

plt.figure(figsize=(9, 6), dpi=100)
_ = plt.hist(mean1000, bins=100)
# plt.axvline(x=np.mean(arr), color='k')
plt.xlabel("Expectation of Game Length (in rounds)")
plt.ylabel("Number of Expectation")
plt.title("Distribution of Expectation of Single Player with Strategy " + str(num) + " of 10000 runs of 1000 simulations")

# mean, ci95l, ci95h = mean_confidence_interval(mean1000)
# mean, ci99l, ci99h = mean_confidence_interval(mean1000, 0.99)

(ci95l, ci95h) = mean_ci(arr, 0.95)
(ci99l, ci99h) = mean_ci(arr, 0.99)
mean = np.mean(mean1000)


plt.axvline(x = ci95l, color = 'b', label = '95CI')
plt.axvline(x = ci95h, color = 'b', label = '95CI')

plt.axvline(x = ci99l, color = 'r', label = '99CI')
plt.axvline(x = ci99h, color = 'r', label = '99CI')

print("single s" + str(num) + " mean: " + str(mean))
print("single s" + str(num) + " 95CI: (" + str(ci95l) + ", " + str(ci95h) + ")")
print("single s" + str(num) + " 99CI: (" + str(ci99l) + ", " + str(ci99h) + ")")

plt.show()