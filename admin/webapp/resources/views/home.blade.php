@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <form class="form-horizontal" method="post" action="{{route('home.event')}}">
                {{csrf_field()}}
                <div class="form-group{{ $errors->has('event_name') ? ' has-error' : '' }}">
                    <label for="event" class="col-md-4 control-label">Event Name</label>

                    <div class="col-md-6">
                        <input id="event_name" type="text" class="form-control" name="event_name" value="{{ old('event_name') }}" required autofocus>

                        @if ($errors->has('event_name'))
                            <span class="help-block">
                                <strong>{{ $errors->first('event_name') }}</strong>
                            </span>
                        @endif
                    </div>
                </div>
                <div class="form-group{{ $errors->has('latitude') ? ' has-error' : '' }}">
                    <label for="latitude" class="col-md-4 control-label">Latitude</label>

                    <div class="col-md-6">
                        <input id="latitude" type="text" class="form-control" name="latitude" value="{{ old('latitude') }}" required autofocus>

                        @if ($errors->has('latitude'))
                            <span class="help-block">
                                        <strong>{{ $errors->first('latitude') }}</strong>
                                    </span>
                        @endif
                    </div>
                </div>
                <div class="form-group{{ $errors->has('longitude') ? ' has-error' : '' }}">
                    <label for="longitude" class="col-md-4 control-label">Longitude</label>

                    <div class="col-md-6">
                        <input id="longitude" type="text" class="form-control" name="longitude" value="{{ old('longitude') }}" required autofocus>

                        @if ($errors->has('longitude'))
                            <span class="help-block">
                                        <strong>{{ $errors->first('longitude') }}</strong>
                                    </span>
                        @endif
                    </div>
                </div>
                <div class="form-group{{ $errors->has('event_description') ? ' has-error' : '' }}">
                    <label for="event_description" class="col-md-4 control-label">Description</label>

                    <div class="col-md-6">
                        <textarea id="event_description" type="text" class="form-control" name="event_description" value="{{ old('event_description') }}" required autofocus></textarea>

                        @if ($errors->has('event_description'))
                            <span class="help-block">
                                        <strong>{{ $errors->first('event_description') }}</strong>
                                    </span>
                        @endif
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>

            </form>
        </div>
        <div class="col-md-8">
            <h3>Map</h3>
            <div id="map"></div>
        </div>
    </div>
</div>
@endsection
