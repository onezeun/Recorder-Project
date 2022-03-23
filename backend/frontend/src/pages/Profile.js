import React, { useEffect } from "react";
import { Navigate } from 'react-router-dom';
import { useSelector } from "react-redux";
import axios from 'axios';

const Profile = () => {
  const { user: currentUser } = useSelector((state) => state.auth);
  const { isLoggedIn } = useSelector((state) => state.auth);

  // console.log('ProfilePage currentUser', currentUser);

    // const userProfile = axios
    // .get('http://localhost:8080/users')
    // .then(function(result) {
    //   // console.log('data:', result.data.data[8].email);
    //   return result.data.data[8].email
    // })
    // .catch(function(error) {
    //   console.log('에러 발생:', error);
    // })

  //  async function userProfile() {
  //    try {
  //      const response = await axios.get('http://localhost:8080/users')
  //      const userId = response.data.data.userId;

  //      const response2 = await axios.get('http://localhost:8080/users' + userId);
  //      console.log('response >>', response2.data)
  //    } catch(err) {
  //      console.log('Error >>', err);
  //    }
  //  }

  const userProfile = () => {
      
    const userProfiles =
      axios
      .get('http://localhost:8080/users/')
      .then((response) => {
        const userId = response.data.userId;
        let userData;

        axios
        .get('http://localhost:8080/users/' + userId)
        .then((response) => {
            userData = response.data;
            console.log("Response >>", response.data)
        })
        .catch(() => {
        })
        return userData;
      })
      .catch((error) => {
        console.log("Error >>", error);
      })

      return userProfiles;
  }
      
    console.log(userProfile);
    
    // const userProfile = axios
    // .get('http://localhost:8080/users')
    // .then(response => response.data.data[8].email);
    // console.log('userProfile', userProfile);

  // useEffect(() => {
  //   if (currentUser === null) {
  //     navigate('/login', {replace: true});
  //   }
  // }, []);

  if (isLoggedIn) {
  return (
    <div className="container">
      <header className="jumbotron">
        <h3>
          <strong>{currentUser.user}</strong> Profile </h3>
      </header>
      <p>
        <strong>Token:</strong> {currentUser.accessToken.substring(0, 20)} ...{" "}
        {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
      </p>
      <p>
        <strong>Id:</strong> {currentUser.id}
      </p>
      <p>
        <strong>Email:</strong> {userProfile.promise}
      </p>
      <strong>Authorities:</strong>
      <ul>
        {currentUser.roles &&
          currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
      </ul>
    </div>
  );
} else {
  return <Navigate to='/login' replace={true} />
  }
}
export default Profile;