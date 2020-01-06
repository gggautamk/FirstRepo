1. Created a maven project "messanger" with maven dependency. "messanger" is the context root for deploying the application.

2. Created 3 Provider URL(Resful API's) using Jersey Implemenation . Providers provides the same data as given in the pdf as example. All data in String format.
http://localhost:8080/messanger/searchFlightByProviders/Provider1/{origin}/{destination}
http://localhost:8080/messanger/searchFlightByProviders/Provider2/{origin}/{destination}
http://localhost:8080/messanger/searchFlightByProviders/Provider3/{origin}/{destination}

3. Created a servlet "SearchFlightServlet" which has the responsibility for consolidating the data(in the form of JSON) from all providers and storing in 
FlightDetails POJO class. Above provider URL's are consumed as a client with GET request. String data recieved from client is converted to their respective 
datatype in POJO class to make processing of data easier.
All the consolidated data is kept in HashSet to eliminate duplicates, further hashset is converted to TreeSet for sorting order as mentioned in pdf.
Sorted data is displayed in the form of runtime html as a output of the servlet.
http://localhost:8080/messanger/searchFlights/{origin}/{destination}

4. Created a test class "SearchFlightsServiceTest" to test if the services are working fine with 200 response code.

Note: - Application is a maven project. It is deployed with context root as "messanger"
Try below examples --

SUCESS SCENARIO   
http://localhost:8080/messanger/searchFlights/LHR/BOS    --> provides 3 data as per the requirement

NEGATIVE SCENARIO
http://localhost:8080/messanger/searchFlights/LHR/BOSS    --> displays No data found