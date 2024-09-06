from sklearn.mixture import GaussianMixture
import joblib

def train_clustering_model(data):
    """
    Trains a Gaussian Mixture Model (GMM) clustering model on the given data.
    @param data: The preprocessed data as a Pandas DataFrame.
    @return: The trained clustering model.
    """
    X = data[['goals', 'assists', 'minutes_played', 'performance_index', 'pass_accuracy']]
    gmm = GaussianMixture(n_components=4, covariance_type='full', random_state=42)
    gmm.fit(X)
    joblib.dump(gmm, 'player_clustering_model.pkl')
    return gmm

def predict_cluster(gmm, new_data):
    """
    Predicts the cluster labels for the new data using the given clustering model.

    Parameters:
    gmm (GaussianMixture): The trained clustering model.
    new_data (pandas.DataFrame): The new data for which cluster labels need to be predicted.

    Returns:
    numpy.ndarray: The predicted cluster labels for the new data.
    """
    return gmm.predict(new_data)
