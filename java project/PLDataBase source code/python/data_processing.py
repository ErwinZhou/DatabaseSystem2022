import pandas as pd
from sklearn.preprocessing import StandardScaler

def load_and_preprocess_data(file_path):
    data = pd.read_csv(file_path)
    
    # 数据清洗：去除空值和异常值
    data = data.dropna()
    data = data[data['minutes_played'] > 0]

    # 特征提取：创建自定义指标
    data['performance_index'] = (data['goals'] * 0.6 + data['assists'] * 0.4) / data['games_played']

    # 特征缩放：标准化特征
    scaler = StandardScaler()
    data[['games_played', 'goals', 'assists', 'minutes_played', 'performance_index']] = scaler.fit_transform(
        data[['games_played', 'goals', 'assists', 'minutes_played', 'performance_index']])

    return data
