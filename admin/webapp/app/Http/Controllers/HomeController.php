<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Event;

class HomeController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('auth');
    }

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return view('home');
    }

    public function postEvent(Request $request)
    {
        $this->validate($request, [
            'latitude' => 'required',
            'longitude' => 'required',
            'event_name' => 'required',
            'event_description' => 'required',
        ]);

        Event::create([
            'latitude' => $request['latitude'],
            'longitude' => $request['longitude'],
            'event_name' => $request['event_name'],
            'event_description' => $request['event_description'],
        ]);
        return redirect()->back();
    }
}
