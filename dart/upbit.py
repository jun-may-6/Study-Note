import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import MinMaxScaler
import tensorflow as tf

# 1. 가상 데이터 생성 (예시로 코인 가격 데이터 사용)
np.random.seed(0)
data = {
    'price': np.random.rand(1000) * 100,  # 랜덤 코인 가격
    'volume': np.random.rand(1000) * 1000,  # 랜덤 거래량
    'resistance': np.random.rand(1000) * 100,  # 랜덤 저항선 값
    'support': np.random.rand(1000) * 100  # 랜덤 지지선 값
}
df = pd.DataFrame(data)

# 2. 매수/매도 타이밍 생성 (간단한 기준으로)
df['signal'] = np.where((df['price'] > df['resistance']), 1, 0)  # 가격이 저항선을 넘으면 매도 신호

# 3. 데이터 전처리
X = df[['price', 'volume', 'resistance', 'support']].values
y = df['signal'].values

scaler = MinMaxScaler()
X = scaler.fit_transform(X)

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)

# 4. 간단한 LSTM 모델 생성
model = tf.keras.Sequential([
    tf.keras.layers.Input(shape=(X_train.shape[1], 1)),
    tf.keras.layers.LSTM(50, return_sequences=True),
    tf.keras.layers.LSTM(50),
    tf.keras.layers.Dense(1, activation='sigmoid')
])

model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])

# 5. 데이터 형태 조정
X_train = np.expand_dims(X_train, axis=2)
X_test = np.expand_dims(X_test, axis=2)

# 6. 모델 학습
model.fit(X_train, y_train, epochs=10, batch_size=32)

# 7. 예측 및 결과 확인
predictions = model.predict(X_test)
predictions = (predictions > 0.5).astype(int)

# 예측 결과 출력
print("Actual:", y_test[:10])
print("Predicted:", predictions[:10])
