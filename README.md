# makeMeWet
###IoT application used to control automated flower watering system. Consist of:
- **client-flower**: rest-client
    - water pump 
    - controlled by Rasberry Pi
    - open/close the water valve based on scheduler pulled from **server**
- **server**: rest server. It's purpose:
    - for **client-flower**: 
        - serves configuration, 
        - offers endpoint to update status
    - for **client-user**: 
        - serves stauts of: **client-flower**, 
        - offers endpoint to push new watering plans
- **client-user**: rest-client
    - human 
    - sends new schedulers for **client-flower** by **server**
    - gets the statuses
        
        
# Use cases: 
##1. client-flower gets configuration from server:
    - client-flower connects to server, 
        - gets configuration (periodically)
##1. client-flower sends operating status to server:
    - client flower connecst to server, 
        - sends info when operating: (time, watering plan, started watering/finished watering)
##1. server asks client-flower for status:
    - server connects to client-flower, asks for status, 
        - client-flower responses with watering plan
##4. client-user asks for status:
    - client-user calls server and asks for status and gets:
        - log of watering from client-flower
        - watering plan
##5. client-user calls server and sends new watering plan:
    - server confirms, that plan is to be pulled by user

# Important entities:
##Watering plan:
    - when available
    - scheduler
##Watering plan status: 
    - communication stage:
        - pushed by user-client: {pushed, timespamp}
        - pulled by user-flower: {pulled, timespamp}
    - applicability:
        - future_plan
        - in_use
        - expired
        
# Planned work:
1. add live video stream from client-flower
2. support multiple water valves by client-flower
3. support multiple client-users, client-flowers
