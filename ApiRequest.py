import requests
import json
import datetime

# Creates a dictionary with key country and values emails and their available times
def categorizeByCountry(objects):
    countries = {}
    for obj in objects:
        countryName = obj['country']
        currList = countries.get(countryName,{})
        currList[obj['email']] = obj['availableDates']
        countries[countryName] = currList
    return countries

def findCommondate(dictionary):
    dateDict = {}
    for k,dates in dictionary.items():
        for i in range (1,len(dates)):
            prevDate = datetime.datetime(int(dates[i-1][0:4]),int(dates[i-1][5:7]),int(dates[i-1][8:10]))
            currDate = datetime.datetime(int(dates[i][0:4]),int(dates[i][5:7]),int(dates[i][8:10]))
            difference = currDate-prevDate
            if (difference.days==1):
                consecDates = dates[i-1]+dates[i]
                dateDict[consecDates] = dateDict.get(consecDates,0)+1
    res = (max(dateDict.items(), key=lambda x: x[1]))[0]
    return res

def findListOfAttendeesPerCountry(map,date):
    attendeeList = []
    firstDate = date[0:10]
    secondDate = date[10:]
    for email,dates in map.items():
        for i in range (1,len(dates)):    
            if (dates[i-1] == firstDate and dates[i] == secondDate):
                attendeeList.append(email)
                break
    return attendeeList
    
def createFinalJson(dictionary):
    countryList = []
    for k,v in dictionary.items():
        mostCommonTwoDates = findCommondate(v)
        attendeeList = findListOfAttendeesPerCountry(v,mostCommonTwoDates)
        attendeeCount = len(attendeeList)
        country = {"name":k,
                   "startDate": mostCommonTwoDates[0:10],
                   "attendees": attendeeList,
                   "attendeeCount": attendeeCount}
        countryList.append(country)
    return {"countries": countryList}
            


URL = "https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=8e1c4e6a0a736e344ea0104bf581"

res = requests.get(url=URL)
data = res.json()['partners']
newData = categorizeByCountry(data)
finalResult = createFinalJson(newData)
URL = "https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey=8e1c4e6a0a736e344ea0104bf581"
requests.post(url=URL,json=finalResult).json()
