from sklearn.ensemble import GradientBoostingRegressor
import joblib

def train_performance_model(data):
    X = data[['games_played', 'goals', 'assists', 'minutes_played', 'performance_index']]
    y = data['future_performance']  # 目标变量，需提前计算或标注

    model = GradientBoostingRegressor(n_estimators=200, learning_rate=0.1, max_depth=4, random_state=42)
    model.fit(X, y)

    joblib.dump(model, 'player_performance_predictor.pkl')
    return model

def predict_performance(model, new_data):
    return model.predict(new_data)
