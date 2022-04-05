# SIMPL PAY LATER
Building a Simple Pay-Later Service :
As a pay later service we allow our users to buy goods from a merchant now, and then allow
them to pay for those goods at a later date.

The service works inside the boundary of following simple constraints -

● Let's say that for every transaction paid through us, merchants offer us a discount.
    For example, if the transaction amount is Rs.100, and merchant discount offered
to us is 10%, we pay Rs. 90 back to the merchant.
    
    ○ The discount varies from merchant to merchant.
    ○ A merchant can decide to change the discount it offers to us, at any point in time.

● All users get onboarded with a credit limit, beyond which they can't transact.

    ○ If a transaction value crosses this credit limit, we reject the transaction.
Use Cases :
    
    There are various use cases our service is intended to fulfil -
    ○ allow merchants to be onboarded with the amount of discounts they offer
    ○ allow merchants to change the discount they offer
    ○ allow users to be onboarded (name, email-id and credit-limit)
    ○ allow a user to carry out a transaction of some amount with a merchant.
    ○ allow a user to pay back their dues (full or partial)

● Reporting:

    ○ how much discount we received from a merchant till date
    ○ dues for a user so far
    ○ which users have reached their credit limit
    ○ total dues from all users together

# Prerequisite
    It is assumed that postgres in installed and is running on port 5432
    It is assumed that there exists a database with name simpl in postgres

# Getting Started

This is a spring boot application , please run it using following command :

java -jar pay-later-0.0.1-SNAPSHOT.jar new user akash akash@users.com 3000

java -jar pay-later-0.0.1-SNAPSHOT.jar new merchant swiggy swiggy@merchant.com 2%

java -jar pay-later-0.0.1-SNAPSHOT.jar new txn akash swiggy 500

java -jar pay-later-0.0.1-SNAPSHOT.jar report discount swiggy

java -jar pay-later-0.0.1-SNAPSHOT.jar payback akash 400

java -jar pay-later-0.0.1-SNAPSHOT.jar report total-dues

    
