/* eslint-disable @next/next/no-img-element */
import classes from './Favourites.module.css';
import { useEffect,useState } from 'react';
import Axios from '../../axios';
import { FavouritesProduct } from '../../models/interfaces/FavouritesProduct';
import Spinner from '../../components/UI/Spinner/Spinner';

  import { useSelector } from "react-redux";
  import { State } from "../../store/reducers/rootReducers";

const Favourites= () => {

    const [favourites, setFavorites] = useState<FavouritesProduct[]>([]);
    const [loading, setLoading] = useState<boolean>(true);

    const list = useSelector((state: State) => state.authreducer);
    const username = list.user;
    console.log("Fuck user="+username);

    useEffect(() => {
      Axios.get<FavouritesProduct[]>(`/favouritesproductbyusername/${username}`,{
        headers: {
          Authorization: "Bearer" + list.token,
        },
      })
        .then((res) => {
          setLoading(false);
          setFavorites(res.data);
        })
        .catch((err) => {
          setLoading(false);
        });
    }, []);

    let formData = (
      <table className={classes.OrderTable}>
        <tr>
          <th>Image</th>
          <th>Name</th>
          <th>Price</th>
          <th>Quantity</th>
        </tr>
        {favourites.map((data) => {
          return (
            <tr key={data.id}>
              <td>
                <div>
                  <img src={data.image} alt="Favourites Photo" />
                </div>
              </td>
              <td>{data.name}</td>
              <td>{data.price}</td>
              <td>{data.quantity}</td>
            </tr>
          );
        })}
      </table>
    );

    if(loading){
        formData= <Spinner/>
    }

    return (
      <div className={classes.FavouritesContainer}>
        <h1>Your Favourites</h1>
        {formData}
      </div>
    );
}
export default Favourites;