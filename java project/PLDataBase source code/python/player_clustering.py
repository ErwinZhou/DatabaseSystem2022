from sklearn.mixture import GaussianMixture
import joblib

def train_clustering_model(data):
    X = data[['goals', 'assists', 'minutes_played', 'performance_index', 'pass_accuracy']]
    gmm = GaussianMixture(n_components=4, covariance_type='full', random_state=42)
    gmm.fit(X)
    joblib.dump(gmm, 'player_clustering_model.pkl')
    return gmm

def predict_cluster(gmm, new_data):
    return gmm.predict(new_data)
