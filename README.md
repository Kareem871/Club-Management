# Business Rules:
- There is only admin users
- Two types of clients, member or not member
  * Member: the client who has subscription (For one month or more, based on the added period value)
  * Not memeber (one-time member): client visited one time in one day
- Members can renew their supscription every month
- Can't add more than One-time member with the same day, but can be multiple with different days, example:
           Name: Sam, Registration Date: 14/06/2021 ✔️
           Name: Sam, Registration Date: 01/08/2021 ✔️
           Name: Sam, Registration Date: 01/08/2021 ❌
           
- Member user can be added as "One-time member", but not within the same supscriped month, example:
           Name: Sam, Registration Date: 14/06/2021 (As member for one or more monthes)
           Name: Sam, Registration Date: 20/06/2021 (As "one-time member") ❌ 
           ===============================================================================
           
           Name: John, Registration Date: 14/06/2021 (As member for one or more monthes)
           Name: John, Registration Date: 07/03/2021 (As "one-time member") ✔️
           
- Admin can delete/deactivate clients
