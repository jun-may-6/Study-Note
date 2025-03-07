import {combineReducers} from 'redux';
import menuReducer from './MenuModules';
import reviewReducer from './ReviewModules';

const rootReducer = combineReducers({
    menuReducer,
    reviewReducer
});

export default rootReducer;