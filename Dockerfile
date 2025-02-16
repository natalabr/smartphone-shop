#base image
FROM mongo

#new directory for application files
RUN mkdir /app

#copy app files from host machine to image filesystem
COPY src /app

#set directory for executing future commands
WORKDIR /app

#run the main class
CMD java view.main.Main
