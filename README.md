# Smart-Home
This is an Energy Management System (EMS), it manages the smart appliances in houses on a city scale.

![Image of EMS](https://www.bluesky-energy.eu/wp-content/uploads/2018/09/EMS-House-engl600x450.png) 
taken from www.bluesky-energy.eu/en/2018/09/12/smart-ems-energy-management-system/

The algorithm takes the entire list of appliances, calculates the total power used and checks if the total amount is greater than the limit specified. 

If power usage exceeds or is in danger zone, program finds the location with the largest energy usage and turns off smart appliances to help lower the power usage. This is done until the total power used is less than the specified power usage limit. 

Things we can improve on is to optimize the algorithm which determines the amount of appliances to turn off.
