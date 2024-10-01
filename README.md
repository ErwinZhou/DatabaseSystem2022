#  Database System 2023 Spring
## Nankai University
###  College of Computer and Cyber Science Sophomore
#### Senior Experimentalist: Yanlong Wen

#### Course Score: A(94)

Personally speaking,  presented by Teacher Wen, **Database System is one of the most well-organized and intriguing course** I've ever taken during my study at Nankai University.



**Final Project:** A minor Database Management System matching all the requirements

**My Project: Premier League Database Management System** with all corresponding functions:

1. FA Mode(The Football Association):
   * Viewing all games, clubs, coaches, referees
   * Viewing all info of forward players and goalkeepers
   * Relegation on specific Premier League clubs
2. Club Coach Mode:
   * Viewing top goal scorers of Premier League Season 2022-2023
3. Club Manager Mode:
   * Purchase players for your own club
   * Sell out specific player belonging to your club
   * Query on all players belonging to your club
   * Update on position and transfer value of your club players
4. Intelligent Part(2024.1 - 2024.4 update):
   * Predict players' future performance based on their historical data
   * Chatbot interaction to give specific advice on many aspects of the game
   * Help the club coach and manager to make more comprehensive decisions

* **Front-End:**  JAVA GUI
* **Back-End:** JDBC MySQL
* **Data Source:** [Official Premier League Website](https://www.premierleague.com/)
* **Simple DEMO:**
  * Main Page:
<img src="https://raw.githubusercontent.com/ErwinZhou/pics_home/main/works/projects/NKU/database_system_2022/demo-1.png" width="600" height="400" />

  * Club Manager Mode:
<img src="https://raw.githubusercontent.com/ErwinZhou/pics_home/main/works/projects/NKU/database_system_2022/demo-3.png" width="600" height="400" />


  * Top Goal Scorers:
<img src="https://raw.githubusercontent.com/ErwinZhou/pics_home/main/works/projects/NKU/database_system_2022/demo-2.png" width="600" height="400" />


* **Relationship Diagram**
<img src="https://raw.githubusercontent.com/ErwinZhou/pics_home/main/works/projects/NKU/database_system_2022/RD.png" width="600" height="400" />

* **Code Structure:**
```
/project-root
│── startframe.java
├── /python                               # Intelliegent Part using Python
│   ├── data_preprocessing.py          # Data Preprocessing for later use
│   ├── performance_prediction.py      # Predict players' future performance
│   ├── player_clustering.py           # Cluster players based on their performance
│   └── ...
│
├── /java                                 # Main Project using Java
│   ├── Main.java                      # Main Entrance
│   ├── JDBCUtils.java                 # JDBC Connection
│   |── defender.java                  # Player Class for defenders
|   |── midfielder.java                # Player Class for midfielders
│   |── forward.java                   # Player Class for forwards
│   |── goalkeeper.java                # Player Class for goalkeepers
│   |── club.java                      # Club Class
│   |── coach.java                     # Coach Class
│   |── referee.java                   # Referee Class
│   |── match.java                     # Match Class
│   |── pitch.java                     # Pitch Class
│   |── BackgroundMusic.java           # Background Music
│   |── choseUserDialog.java           # Choose User Dialog
│   |── FAFrame.java                   # FA Mode Frame
│   |── ManagerFrame.java              # Manager Mode Frame
│   |── CoachFrame.java                # Coach Mode Frame
│   ├── PerformancePredictor.java      # Predict players' future performance using python model
│   ├── PlayerClustering.java          # Cluster players based on their performance using python model
│   |── DecisionSupport.java           # Decision Support System using an incorporation of the above two models
│   |── Chatbot.java                   # Chatbot using OpenAI API
│   └── ...
├── /sql                                  # SQL scripts
│   ├── premierleague.sql              # Database creation and data insertion
|   └── ...
└── /report                               # Course Report
    ├── Database System Report-CN.pdf
    └── ...
```

**This work, among many, is one of the most satisfactory projects I've ever done 😍. It's a great pleasure to implement something I'm passionate about**. And it sparks my interest in designing and developing more complex and intelligent systems in the future 👨‍💻.

Continue to update......

All the modifications in the near future will be specific.

Feel free to contact me on ErwinZhou@outlook.com







## 南开大学

### 计算机与网络空间安全学院大二

#### 高级实验师：温延龙（龙龙！

#### 课程分数：94

不多说了，懂的都懂，计网最神的课之一。优秀且合理的课程安排，答疑和全面的习题，视频讲解和丰富的课程资源。龙龙耐心的讲解，上机考试+期末大作业。

在这里提供了2022年的网络安全学院数据库系统课程期末大作业。

我基于**Java语言的前端和SQL语言的后端**，使用Eclipse作为IDE，选择了**英格兰足球超级联赛**作为主题。

部分球员和俱乐部数据来源于[英超官方网站](https://www.premierleague.com/)。

实现了英足总模式+俱乐部经理+教练模式三种不同玩法，包括购买球员，出售球员，修改球员位置身价，降级俱乐部，积分榜和射手榜查询等多种功能。**更详细的介绍可以阅读我的课程报告。**

于后期慢慢完成了**智能部分**，包括根据球员历史数据预测未来表现，聊天机器人(Open AI接口)提供建议，帮助俱乐部教练和经理做出更全面的决策。

**作为我大学至今最满意的课程作业之一，对实现了自己所热爱的东西的感觉十分开心。**

内容会持续更新

任何有改进的内容都可以联系我，

邮箱[erwinzhou021227@126.com](mailto:erwinzhou021227@126.com)
