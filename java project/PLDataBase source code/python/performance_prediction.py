from sklearn.ensemble import GradientBoostingRegressor
import joblib

def train_performance_model(data):
    # Extract the features and target variable from the data
    X = data[['games_played', 'goals', 'assists', 'minutes_played', 'performance_index']]
    y = data['future_performance']  

    # Create a Gradient Boosting Regressor model with specified parameters
    model = GradientBoostingRegressor(n_estimators=200, learning_rate=0.1, max_depth=4, random_state=42)
    
    # Train the model using the extracted features and target variable
    model.fit(X, y)

    # Save the trained model to a file
    joblib.dump(model, 'player_performance_predictor.pkl')
    
    # Return the trained model
    return model

def predict_performance(model, new_data):
    # Use the trained model to predict the performance of new data
    return model.predict(new_data)
