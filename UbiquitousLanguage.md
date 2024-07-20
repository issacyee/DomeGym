# Ubiquitous Language

## Dome Gym

### Participant

+ A **user** can _create_ a **participant profile**
+ **Participant** can _reserve_ a **spot** in a **session**
+ A **session** takes place in a **room**
+ A **session** has a single **trainer** and a maximum number of **participants**
+ A **gym** can have multiple **rooms**

### Admin

+ A **user** can _create_ an **admin profile**
+ An **admin** can have an **active subscription**
+ A **subscription** can have multiple gyms
+ An **active subscription** can be of type **Free**, **Starter**, or **Pro**

### Trainer

+ A **user** can _create_ a **trainer profile**
+ A **trainer** can _teach_ **sessions** across **gyms** and **subscriptions**

---

### Domain Objects

+ User
+ Participant
+ Admin
+ Trainer
+ Subscription
+ Gym
+ Room
+ Session

---

### Invariant

#### Session Invariants

+ A session cannot contain more than the maximum number of participants
+ A reservation cannot be canceled for free less than 24 hours before the session starts

#### Gym Invariants

+ A gym cannot have more rooms than the subscription allows

#### Room Invariants

+ A room cannot have more session than the subscription allows
+ A room cannot have two or more overlapping sessions

#### Subscription Invariants

+ A subscription cannot have more than the subscription allows

#### Trainer Invariants

+ A trainer cannot teach two or more overlapping sessions

#### Participant Invariants

+ A participant cannot reserve overlapping sessions