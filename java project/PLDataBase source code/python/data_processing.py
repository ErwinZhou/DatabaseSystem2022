import pandas as pd
from sklearn.preprocessing import StandardScaler

def load_and_preprocess_data(file_path):
    # Load the data from the specified file path
    data = pd.read_csv(file_path)
    
    # Data cleaning: Remove missing values and outliers
    data = data.dropna()
    data = data[data['minutes_played'] > 0]

    # Feature extraction: Create custom metrics
    data['performance_index'] = (data['goals'] * 0.6 + data['assists'] * 0.4) / data['games_played']

    # Feature scaling: Standardize the features
    scaler = StandardScaler()
    data[['games_played', 'goals', 'assists', 'minutes_played', 'performance_index']] = scaler.fit_transform(
        data[['games_played', 'goals', 'assists', 'minutes_played', 'performance_index']])

    return data
