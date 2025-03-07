# Build stage
FROM node:20-alpine AS build

# Set the working directory in the container
WORKDIR /app

# Copy the contents of this directory to the container
COPY . .

# Install dependencies
RUN npm install

# Build the application
RUN npm run build

# Run stage
FROM nginx:alpine

# Copy the built files from the build stage
COPY --from=build /app/dist/case-developer-frontend/browser /usr/share/nginx/html

# Copy custom nginx configuration if needed
# COPY nginx.conf /etc/nginx/nginx.conf

# Expose the port the application runs on
EXPOSE 80

# Start nginx
CMD ["nginx", "-g", "daemon off;"]
