

＜＜＜＜＜準備中＞＞＞＞＞






---

*ichienyadoローカル開発手順*

---

## 必要なもの

+ docker
+ docker-compose
+ git

---

## 1. githubから、ichienyadoのリポジトリ（developブランチ）を取得します。

（例）  
sudo git clone -b develop https://github.com/msuzuki83/ichienyado.git

---

## 2. 手順1でローカルに保存した「ichienyado」ディレクトリの「local」に移動します。

cd ichienyado/local  

---

## 3. ローカル開発用の「docker-compose.yml」を編集します。

「.env.template」ファイルをコピーし、「.env」という名前で保存します。  
「.env」ファイルを編集し、「ichienyado」ディレクトリのパスを記述・保存してください。  
＊ 「.env」ファイルは .gitignore に記述されているため、他者に共有されません。  
＊ ローカル開発環境のみ、ソースコードをHostと共有しています。  

（例）  
ICHIENYADO_VOLUME_PATH=/Users/username/github/ichienyado

---  

## 4. 手順3の「docker-compose.yml」を利用し、ichienyadoをビルドします。
＊ --no-cache オプションを付けていますが、必要がない場合は外してください。  

（例）  
sudo docker-compose build --no-cache  

---

## 5. 手順3の「docker-compose.yml」を利用し、ichienyadoを起動します。

sudo docker-compose up -d  

---

## 6. 手順5で起動したWebサーバに、ブラウザからアクセスします。

http://localhost:9000  
