import { Fragment, useEffect } from "react";
import Navigation from "../components/Navigation/navigation";
import Footer from "../components/Footer/footer";
import { useDispatch } from "react-redux";
import * as ActionCreators from "../store/actions/auth/action-creators";
import { bindActionCreators } from "redux";
const StandardLayout = (props:any) => {

     const dispatch = useDispatch();
     const { authCheckState } = bindActionCreators(
       ActionCreators,
       dispatch
     );



     
   useEffect(() => {
     authCheckState();
    //   dispatch({
    //     type:'hello',
    //     token:'fuck',
    //   });
   }, []);

    

    return (
        <Fragment>
            <Navigation/>
            <main>{props.children}</main>
            <Footer/>
        </Fragment>
    );
}
export default StandardLayout;